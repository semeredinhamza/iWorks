<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iworks.HelloAppEngine" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
  <link href='//fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
  <title>iWorks: sign in</title>
</head>
<div class="container">
  <h2>
    Sign in
  </h2>

  <form method="POST" action="/sign_in">
	
    <div>
      <label for="email">Email</label>
      <input type="text" name="email" id="email" size="40" value="${fn:escapeXml(email)}" class="form-control" />
    </div>

    <div>
      <label for="password">Password</label>
      <input type="text" name="password" id="password" size="40" value="${fn:escapeXml(password)}" class="form-control" />
    </div>

    <button type="submit">Sign in</button>
  </form>
</div>
</html>
