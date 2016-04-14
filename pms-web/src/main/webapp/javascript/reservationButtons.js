function searchReservation(){
    URL = "reservationSearch.jsp?selHotel=1";
    appeareance = "width=700,height=450,left=50,top=100,scrollbars=yes,status=yes";
    // 'refsearch' nos permitira acceder a la ventana
    refsearch = window.open(URL,"search",appeareance);
}

function lookForGuest(){
    URL = "customerSearch.jsp?selHotel=1";
    appeareance = "width=600,height=450,left=50,top=100,scrollbars=yes,status=yes";
    refsearch = window.open(URL,"search",appeareance);
}

function addCustomer(){
    window.location.href = "customer.jsp?hotelId=1";
}

function removeCustomer() {
    guestId    = document.frmres.guestname.value;
    parameters = "?remove=remove" + "&guestId=" + guestId;
    window.location.href = "RemoveReservationGuest" + parameters;
}

function showAvailability(){
    URL = "AvailabilityServlet?selHotel=" + frmres.hotel.value +
          "&startDate=" + frmres.arrival.value + "&selPeriod=W&show=Mostrar";
    appeareance = "width=760,height=350,left=50,top=100,scrollbars=yes,status=yes";
    window.open(URL,"availability",appeareance);
}
