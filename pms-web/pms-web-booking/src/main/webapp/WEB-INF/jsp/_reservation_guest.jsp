<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table width="100%">
		<colgroup width="30%"></colgroup>
		<colgroup width="70%"></colgroup>
	<!--thead align="center">
		<tr><td colspan="2"></td></tr>
	</thead-->

	<tbody>
		<c:set var="guests" value="${res.guests}" />
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr><td class="label">
				<label for="guestname">
				Guest(s)&nbsp;<%--${fn:length(guests)}--%></label></td>
			<td><select name="guest" id="roomGuest" onchange="updateGuestInfo()">
						<c:forEach var="item" items="${guests}" varStatus="status">
					<option value="${status.index}">${item.customerNames}</option>
						</c:forEach>
				</select>
		</tr>

		<tr><td class="label">&nbsp;</td>
			<td><a href="javascript:mngGuests('Add')"
					title="Add a new Guest to Reservation">Add
					<!--img alt="Add" src="images/addGuest.jpg"-->
				</a>&nbsp;
				<a href="javascript:mngGuests('View')"
					title="View Guest information">View
					<!--img alt="View" src="images/viewGuest.jpg"-->
				</a>&nbsp;
				<a href="javascript:removeGuest('Remove')"
					title="Remove a Guest from Reservation">Rem
					<!--img alt="Rem" src="images/removeGuest.jpg"-->
				</a>&nbsp;</td>
		</tr>

		<tr>
			<td class="label">
				<label for="document">Document</label></td>
			<td><input type="text" disabled="disabled"
					name="guestDocument" id="guestDocument"
					value="${ReservationForm.guestView.customerDocument}"
					class="Small" /></td>
		</tr>

		<tr>
			<td class="label">
				<label for="nationality">Nationality</label></td>
			<td><input type="text" disabled="disabled"
					name="nationality" id="nationality"
					value="${ReservationForm.guestView.customerDocument}"
					class="Medium" /></td>
		</tr>

		<%--tr>
			<td class="label">
				<label>Source</label>
			<td><input type="text" readonly
					name="sourceName" id="sourceName"
					value="${ReservationForm.sourceName}"
					class="" size="40" maxlength="">
				<a href="javascript:searchSource()" title="Source Search">
					<img class="Tool" alt="Search of Source of Bussiness"
						src="images/lupa01.jpg"></a>
		</tr--%>

		<%--tr>
			<td class="label">
				<label for="sourceId">Source Id</label></td>
			<td><input type="text" readonly="readonly"
					name="idSource" id="idSource"
					value="${res.idSource}"/></td>
		</tr--%>

		<tr>
			<td class="label">
				<label for="companyPhone">Phone Number</label></td>
			<td><input type="text" readonly="readonly"
					name="companyPhone" id="companyPhone"
					value="${ReservationForm.sourcePhone}"
					class="Small" /></td>
		</tr>

		<tr>
			<td class="label">
				<label>Contact Name</label></td>
			<td><input type="text" readonly="readonly"
					name="item.contactName" id="contactName"
					value="${item.contactName}" maxlength="50"
					class="Medium" />
				<a href="javascript:searchContact()" title="Contact Search">
					<img class="Tool" alt="Search of Contact"
						src="images/lupa01.jpg"></a>
		</tr>

		<!--
		<tr>
			<td colspan="2">
				<label>Special Attentions</label>
			</td>
		</tr>
		<tr>
            <td colspan="2">
            	<select name="item.attentions" class="Large" id="attentions">
                <c:forEach var="item" items="${packages}">
                    <c:set var="selected" value="" />
                    <c:if test="${ item.packageId eq res.packageCode }" >
                        <c:set var="selected" value="SELECTED" />
                    </c:if>
		            <option value="${item.elementId}" ${selected}> ${item.description}
                </c:forEach>
					<option value="1" selected>SPECIAL ATENTS.
                </select></td>
              </tr>
              -->
              
		<tr>
			<td colspan="2" align="center"><br />
				<a href="javascript:setHotelInstructions()">Hotel Instructions</a>
				<a href="javascript:setSpecialAttentions()">Special Attentions</a></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		</tbody>
	</table>
