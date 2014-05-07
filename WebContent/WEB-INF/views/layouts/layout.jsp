<%@ page language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        
        <title><tiles:insertAttribute name="pageTitle"/></title>
        
        <script src="/xref/scripts/opensource/jquery-1.7.1.js" type="text/javascript" ></script>
        <link href="/xref/static/content/960_16_col.css" rel="stylesheet" type="text/css" />
        <link href="/xref/static/content/cupertino/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css" />
        <link href="/xref/static/content/site-cupertino.css" rel="stylesheet" type="text/css" />
        <!--[if IE]>
        <link href="/xref/static/content/site-cupertino-ie8.css" rel="stylesheet" type="text/css" />
        <![endif]-->
    </head>
    
    <body>
        <div class="container_12">
		    <div class="grid_12" id="logoPlaceholder">&nbsp;</div>
		    <div id="headerFields" class="grid_12">
		        <span class="help-item-header" link-location="">User Guide</span>
		        &nbsp;|&nbsp;
		        <span class="help-item-header" link-location="">Matching Template</span>
		        &nbsp;|&nbsp;
		        <span class="help-item-header" link-location=""><a href="/xref/j_spring_security_logout">Log Out</a></span>
		    </div>
		    <div class="clear" ></div>
		</div>

        <div id="mainContainer" class="container_12">
            <div class="content">
                
                <div id="menu" class="ui-widget-header noPrint">
					<div id="menuBar" class="container_12">
					    <div id="nav" class="grid_12">
					        <ul>
<!-- 					            <li id="homeLink" class="menu"><a href="/supportal/sp/home/display">Home</a></li> -->
					            
					            <li id="maintenanceLink" class="menu"><a href="/xref/xr/maintenance/supply">Maintenance</a></li>
					            
					            <li id="searchLink" class="menu"><a href="/xref/xr/search/display">Search</a></li>
					            <li id="reportsLink" class="menu"><a href="/xref/xr/reports/display">Reports</a></li>
					            <li id="matchingLink" class="menu"><a href="/xref/xr/matching/display">Matching</a></li>
					            <li id="requestsLink" class="menu"><a href="/xref/xr/requests/display">Requests</a></li>
					        </ul>
					    </div>
					</div>
				    <div class="clear" ></div>
                </div>
				<div id="menuSecondLevel" class="ui-widget-content noPrint">
				   <div class="container_12">
				       <div class="grid_12">
				           <div id="emptySecondLevel" class="second-level-menu-group hidden">
			                    &nbsp;
			               </div>
                               <div id="maintenanceLinkSecondLevel" class="second-level-menu-group hidden">
                                   <ul>
	                              <li id="unitedItemDashboardMenuItem"><a href="/xref/xr/maintenance/supply">United Item</a></li>
	                              <li id="lagasseItemDashboardMenuItem"><a href="/xref/xr/maintenance/lagasse">Lagasse Item</a></li>
	                              <li id="resellerDashboardMenuItem"><a href="/xref/xr/maintenance/reseller/display">Reseller</a></li>
	                              <li id="matchTypeDashboardMenuItem"><a href="/xref/xr/maintenance/matchtype/display">Match Type</a></li>
	                              <li id="xrefTypeDashboardMenuItem"> <a href="/xref/xr/maintenance/xreftype/display">XRef Type</a></li>
	                              <li id="syncSystemsDashboardMenuItem"><a href="/supportal/sp/ssr/list/display/pending">Sync Systems</a></li>
	                              <li id="massMaintenanceDashboardMenuItem"><a href="/supportal/sp/ssr/list/display/pending">Mass Maintenance</a></li>
	                              <li id="massMaintenanceTemplateMenuItem"><a href="/supportal/sp/ssr/list/display/pending">Mass Maintenance Template</a></li>
                                   </ul>
		                     </div>
		                 </div>
				         <div class="clear" ></div>
				    </div>
				</div>
                <tiles:insertAttribute name="content" />
            </div>
        </div>

	   <%-- 
	        The following are common scripts needed in most pages of the application.  These are placed at the end
	        of the file to improve performance.
	    --%>
	    <tiles:importAttribute name="primaryMenuSelected" scope="request" />
	    <tiles:importAttribute name="secondaryMenuSelected" scope="request" />
	    <script type="text/javascript" >
	        var primaryMenuSelected = "${primaryMenuSelected}";
	        var secondaryMenuSelected = "${secondaryMenuSelected}";
	    </script>
	    <!--[if IE]>
	    <script src="/xref/scripts/supplierportal/common/json2.js" type="text/javascript"></script>
	    <![endif]-->
	    <script src="/xref/scripts/opensource/jquery-1.7.1.js" type="text/javascript" ></script>
	    <script src="/xref/scripts/opensource/jquery-ui-1.8.21.custom.js" type="text/javascript" ></script>
	    <script src="/xref/scripts/opensource/knockout-2.1.0.debug.js" type="text/javascript" ></script>
	    <script src="/xref/scripts/opensource/knockout.mapping-2.4.1.js" type="text/javascript" ></script> 
	    <script src="/xref/scripts/xref/common/spmodel.js" type="text/javascript"></script>
	    <script src="/xref/scripts/xref/common/baseviewmodel.js" type="text/javascript"></script>
	    <script src="/xref/scripts/xref/common/pleasewaitdialog.js" type="text/javascript"></script>
	    <script src="/xref/scripts/xref/common/global.js" type="text/javascript"></script>

	    <tiles:useAttribute id="pageScripts" name="pageScripts" classname="java.util.List" />
        <c:forEach var="pageScript" items="${pageScripts}">
            <script src="/xref/scripts/${pageScript}" type="text/javascript"></script>
        </c:forEach>
    
        <div id="ajaxSessionTimeoutDialog" style="display:none">
	        <span>Your session has expired.  Your page will refresh in </span>
	        <span id='pageRefreshCountdownSeconds'></span>
	        <span> seconds.</span>
	    </div>
    </body>
</html>
