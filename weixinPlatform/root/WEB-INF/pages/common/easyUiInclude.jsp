<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet"  type="text/css"  href="${basePath}/easyUi/css/default.css" />
<link rel="stylesheet"  type="text/css"  href="${basePath}/easyUi/js/themes/bootstrap/easyui.css" />
<link rel="stylesheet"  type="text/css"  href="${basePath}/easyUi/js/themes/icon.css" />
<script type="text/javascript"  src="${basePath}/easyUi/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.easyui.min.1.3.3.js"></script>
<script type="text/javascript"  src="${basePath}/easyUi/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"  src="${basePath}/easyUi/js/locale/easyui-optionbox.js"></script>
<script type="text/javascript"  src="${basePath}/easyUi/js/jquery.uploadify.v2.1.0.min.js"></script>
<script type="text/javascript"  src="${basePath}/easyUi/js/swfobject.js"></script>
<link rel="stylesheet"  href="${basePath}/easyUi/css/uploadify.css"  type="text/css"  media="screen" />
<script type="text/javascript"  src="${basePath}/easyUi/js/comm.js"></script>
<c:set var="basePath" value='<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()%>' />