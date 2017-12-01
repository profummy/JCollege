<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/timetable.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile Information</title>
</head>
<body>

<h1>View Profile Details for ${student.username}</h1>

<table>
	<tr>
		<th>Username</th>
		<td>${student.username}</td>
	</tr>
	<tr>
		<th>First Name</th>
		<td>${student.firstName}</td>
	</tr>
	<tr>
		<th>Last Name</th>
		<td>${student.lastName}</td>
	</tr>
	<tr>
		<th>Address</th>
		<td>${student.address}</td>
	</tr>
	<tr>
		<th>Gender</th>
		<td>${student.gender}</td>
	</tr>
	<tr>
		<th>Phone Number</th>
		<td>${student.phoneNumber}</td>
	</tr>
	<tr>
		<th>Date of Birth</th>
		<td><fmt:formatDate value="${student.dOB}" type="both" pattern="dd/MM/YYYY"/></td>
	</tr>
	<tr>
		<th>Courses enrolled on</th>
		<td>
			<c:forEach items="${student.courseList}" var="c">
						${c.courseName}<br/>
			</c:forEach>
		</td>
	</tr>
</table>

<h2> Student Timetable</h2>


	<table>
			<tr>
				<th>Time</th>
				<th>Monday</th>
				<th>Tuesday</th>
				<th>Wednesday</th>
				<th>Thursday</th>
				<th>Friday</th>
			</tr>
			<tr>
				<th>9.00 - 10.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>10.00 - 11.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>11.00 - 12.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>12.00 - 13.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>13.00 - 14.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>14.00 - 15.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>15.00 - 16.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>16.00 - 17.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
	</table>


</body>
</html>