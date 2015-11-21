<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.log4j.Level" %>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Arrays" %>

<% long beginPageLoadTime = System.currentTimeMillis();%>

<html>
<head>
    <title>Log4J Administration</title>
    <style type="text/css">

        <!--
        #content {
            margin: 0px;

            padding: 0px;
            text-align: center;
            background-color: #ccc;

            border: 1px solid #000;
            width: 100%;
        }

        body {
            position: relative;
            margin: 10px;

            padding: 0px;
            color: #333;
        }

        h1 {
            margin-top: 20px;
            font: 1.5em Verdana, Arial, Helvetica sans-serif;
        }

        h2 {
            margin-top: 10px;
            font: 0.75em Verdana, Arial, Helvetica sans-serif;
            text-align: left;
        }

        a, a:link, a:visited, a:active {
            color: red;
            text-decoration: none;
            text-transform: uppercase;
        }

        table {
            width: 100%;
            background-color: #000;
            padding: 3px;
            border: 0px;
        }

        th {
            font-size: 0.75em;
            background-color: #ccc;
            color: #000;
            padding-left: 5px;
            text-align: center;
            border: 1px solid #ccc;
            white-space: nowrap;

        }

        td {
            font-size: 0.75em;
            background-color: #fff;
            white-space: nowrap;

        }

        td.center {
            font-size: 0.75em;
            background-color: #fff;
            text-align: center;

            white-space: nowrap;
        }

        .filterForm {

            font-size: 0.9em;
            background-color: #000;
            color: #fff;
            padding-left: 5px;
            text-align: left;
            border: 1px solid #000;

            white-space: nowrap;
        }

        .filterText {

            font-size: 0.75em;
            background-color: #fff;
            color: #000;
            text-align: left;

            border: 1px solid #ccc;
            white-space: nowrap;

        }

        .filterButton {
            font-size: 0.75em;

            background-color: #000;
            color: #fff;

            padding-left: 5px;
            padding-right: 5px;

            text-align: center;
            border: 1px solid #ccc;

            width: 100px;
            white-space: nowrap;
        }

        -->
    </style>
</head>
<body onLoad="javascript:document.logFilterForm.logNameFilter.focus();">

<%
    String containsFilter = "Contains";
    String beginsWithFilter = "Begins With";

    String[] logLevels = {"debug", "info", "warn", "error", "fatal", "off"};
    String targetOperation = (String) request.getParameter("operation");
    String targetLogger = (String) request.getParameter("logger");
    String targetLogLevel = (String) request.getParameter("newLogLevel");
    String logNameFilter = (String) request.getParameter("logNameFilter");
    String logNameFilterType = (String) request.getParameter("logNameFilterType");

%>
<div id="content">
<h1>Log4J Administration</h1>

<div class="filterForm">

    <form action="LoggingLevel.jsp" name="logFilterForm">Filter Loggers:&nbsp;&nbsp;
        <input name="logNameFilter" type="text" size="50" value="<%=(logNameFilter == null ? "":logNameFilter)%>"
        class="filterText"/>

        <input name="logNameFilterType" type="submit" value="<%=containsFilter%>" class="filterButton"/>&nbsp;

        <input name="logNameClear" type="button" value="Clear" class="filterButton"
        onmousedown='javascript:document.logFilterForm.logNameFilter.value="";'/>

        <param name="operation" value="changeLogLevel"/>
    </form>
</div>
<div class="filterForm">
Recommended Filter Loggers : 
<ul>
<li>com.epsilon</li>
<li>com.epsilon.common</li>
<li>com.epsilon.webservice.business</li>
<li>com.epsilon.webservice.proc</li>
<li>org.*  -> Weblogic,CXF,Spring logging need to be set to WARNING level</li>
</ul>
</div>
<table cellspacing="1">
    <tr>
        <th width="25%">Logger</th>

        <th width="25%">Parent Logger</th>
        <th width="15%">Effective Level</th>

        <th width="35%">Change Log Level To</th>
    </tr>

    <%
        Enumeration loggers = LogManager.getCurrentLoggers();
        Boolean logfilters = false;
        Boolean weblogfilters = false;
        String search_str = null;
        String webloggers = "org.*";
        HashMap loggersMap = new HashMap(128);
        Logger rootLogger = LogManager.getRootLogger();
     /*  if (!loggersMap.containsKey(rootLogger.getName())) {

            loggersMap.put(rootLogger.getName(), rootLogger);
        }*/
        
        while (loggers.hasMoreElements()) {
            Logger logger = (Logger) loggers.nextElement();
            if(logger.getName().contains("com.epsilon")){
            if (logNameFilter == null || logNameFilter.trim().length() == 0) {
                loggersMap.put(logger.getName(), logger);                
            } else { 
            	if (containsFilter.equals(logNameFilterType)) {
            	if(logNameFilter.equals("com.epsilon.common") || logNameFilter.equals("com.epsilon.webservice.business")
            			||  logNameFilter.equals("com.epsilon.webservice.proc")){
            		logfilters = true;
            		search_str=(String)logNameFilter;
            		loggersMap.put(search_str,logger);        	
            	}
                if (logger.getName().toUpperCase().indexOf(logNameFilter.toUpperCase()) >= 0) {
                    loggersMap.put(logger.getName(), logger);
                }
     
            } 
            }
            }
            if(logger.getName().contains("org.")){
              // System.out.println("loggers name---"+logger.getName());
               if (containsFilter.equals(logNameFilterType)) {
                	if(logNameFilter.equals("org.*")){
                		logfilters = true;
                		search_str = (String)logNameFilter;
                		loggersMap.put(webloggers,logger);   
                		loggersMap.put(logger.getName(), logger); 
                	}   
                	  
                } 
                }
        }
        Set loggerKeys = loggersMap.keySet();

        String[] keys = new String[loggerKeys.size()];

        keys = (String[]) loggerKeys.toArray(keys);

        Arrays.sort(keys, String.CASE_INSENSITIVE_ORDER);
        
        String rootlogger_tmp = null;
        String search_rootlogger_tmp = null;
        Boolean rootlogger = false;
        Boolean search_rootlogger = false;
        
        for (int i = 0; i < keys.length; i++) {
            //System.out.println("keys-----"+keys[i]);
        	Logger logger = null;
            logger = (Logger) loggersMap.get(keys[i]);
            if ("changeLogLevel".equals(targetOperation) && targetLogger.equals(logger.getName())) {
            	
                Logger selectedLogger = (Logger) loggersMap.get(targetLogger);
                selectedLogger.setLevel(Level.toLevel(targetLogLevel));
                
                if(selectedLogger.getName().equals("com.epsilon"))
                {
                	rootlogger = true;
                	rootlogger_tmp = targetLogLevel.toUpperCase();
                }

            }
            else if("changeLogLevel".equals(targetOperation) && targetLogger.equals(search_str)){
                	search_rootlogger = true;
                	search_rootlogger_tmp = targetLogLevel.toUpperCase();
            }
           
            String loggerName = null;
            String loggerEffectiveLevel = null;
            String loggerParent = null;
            
            if(rootlogger){
            if (logger != null) {
                loggerName = logger.getName();
                loggerEffectiveLevel = rootlogger_tmp;
                logger.setLevel(Level.toLevel(loggerEffectiveLevel));
                loggerParent = (logger.getParent() == null ? null : logger.getParent().getName());
            }
            }
            else if(search_rootlogger){
            	if(targetLogger.equals(search_str))
            		loggerName = keys[i];
            	else
                loggerName = logger.getName();
                //System.out.println("loggername--"+loggerName);
                loggerEffectiveLevel = search_rootlogger_tmp;
                logger.setLevel(Level.toLevel(loggerEffectiveLevel));
                loggerParent = (logger.getParent() == null ? null : logger.getParent().getName());
            }
            else{
            	if(logfilters){
            		if(search_str.equals("com.epsilon.common") || search_str.equals("com.epsilon.webservice.business")
                			||  search_str.equals("com.epsilon.webservice.proc") || search_str.equals("org.*")){
            			loggerName = search_str;
                        loggerEffectiveLevel = String.valueOf(logger.getEffectiveLevel());
                        loggerParent = (logger.getParent() == null ? null : logger.getParent().getName());
                        logfilters=false;
            		}
            		else{
                        loggerName = logger.getName();
                        loggerEffectiveLevel = String.valueOf(logger.getEffectiveLevel());
                        loggerParent = (logger.getParent() == null ? null : logger.getParent().getName());
            		}
            	}
            	else{
                loggerName = logger.getName();
                loggerEffectiveLevel = String.valueOf(logger.getEffectiveLevel());
                loggerParent = (logger.getParent() == null ? null : logger.getParent().getName());
            	}
            }
     %>
    <tr>
    <%    
    //System.out.println("loggerName---"+loggerName);
         if(loggerName.equals("com.epsilon.common") || loggerName.equals("com.epsilon.webservice.business") || 
 		   loggerName.equals("com.epsilon.webservice.proc") || loggerName.equals("com.epsilon")
		   || loggerName.equals("org.*")){ System.out.println("if");
    %>
        <td><i><b><%=loggerName%></b></i></td>
    <% } else { System.out.println("else");%>
        <td><%=loggerName%></td>
    <%  } %>
        <td><%=loggerParent%>
        </td>
        <td><%=loggerEffectiveLevel%>

        </td>
        <td class="center">
            <%
                for (int cnt = 0; cnt < logLevels.length; cnt++) {
                    String url = "LoggingLevel.jsp?operation=changeLogLevel&logger=" + loggerName + "&newLogLevel=" + logLevels[cnt] 
                   + "&logNameFilter=" + (logNameFilter != null ? logNameFilter : "") 
                   + "&logNameFilterType=" + (logNameFilterType != null ? logNameFilterType : "");
                //System.out.println("url---"+url);
                   if (logger.getLevel() == Level.toLevel(logLevels[cnt]) || logger.getEffectiveLevel() == Level.toLevel(logLevels[cnt])) {
            %>		
                     [<%=logLevels[cnt].toUpperCase()%>]     
            <%
                    } 
                    else {    	
            %>
                         <a href='<%=url%>'>[<%=logLevels[cnt]%>]</a>&nbsp;
            <%
                    }
                
                }
            %>
        </td>
    </tr>

    <%
        }
    %>
    
</table>
<h2>
    Page Load Time (Millis): <%=(System.currentTimeMillis() - beginPageLoadTime)%>
</h2>
</div>
</body>
</html> 