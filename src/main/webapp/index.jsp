<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="tourOrder" type="com.epam.smailova.travel.model.TourOrder"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TourOrder</title>
  </head>
  <body>
  <h1>${tourOrder.price}</h1>
  <h2>${tourOrder.discount}</h2>

  <c:forEach items="${tourOrder.tours}" var="tour"><%--@elvariable id="tour" type="com.epam.smailova.travel.model.Tour"--%>
      <h3>${tour.name}</h3>
      <div>Employee: ${tour.employee}</div>
      <div>Description: ${tour.description}</div>
      <div>Duration: ${tour.duration}</div>
      <div>Hot: ${tour.hot}</div>
      <div>Price: ${tour.price}</div>
      </c:forEach>
  </body>
</html>
