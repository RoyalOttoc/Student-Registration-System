const form = document.getElementById("myForm");
function remove(){
	return $("#allContacts").empty();
}
function loading(){
	return $.ajax({
            type: 'GET',
            url: 'http://localhost:9999/students/all',
            success: function (studentArray) {
				
                let contactsDiv = $('#allContacts');
                
                
                //$("div#allContacts").html(result);
                //alert("result:" + contactArray);
                contactsDiv.append('<thead class="thead-dark"><tr><th scope="col">ID</th><th scope="col">Name</th><th scope="col">Age</th><th scope="col">Mobile</th><th scope="col">Address</th></tr></thead>');
				contactsDiv.append('<tbody>');
                $.each(studentArray, function (index, student) {
                    var contactInfo = '<tr>';
                    contactInfo += '<th scope="row">' + student.id + '</th>';
                    contactInfo += '<td>' + student.name + '</td>';
                    contactInfo += '<td>' + student.age + '</td>';
                    contactInfo += '<td>' + student.mobile + '</td>';
                    contactInfo += '<td>' + student.address + '</td>';
                    

                    contactsDiv.append(contactInfo);
                });
                contactsDiv.append('</tbody>');
                
            },
            error: function () {
                alert('FAILURE!');
            }
        })
}

$(document).ready(function () {
    $("button#getcontacts").click(function () {
		$("#allContacts").empty();
        $.ajax({
            type: 'GET',
            url: 'http://localhost:9999/students/all',
            success: function (studentArray) {
				
                let contactsDiv = $('#allContacts');
                
                
                //$("div#allContacts").html(result);
                //alert("result:" + contactArray);
                contactsDiv.append('<thead class="thead-dark"><tr><th scope="col">ID</th><th scope="col">Name</th><th scope="col">Age</th><th scope="col">Mobile</th><th scope="col">Address</th></tr></thead>');
				contactsDiv.append('<tbody>');
                $.each(studentArray, function (index, student) {
                    var contactInfo = '<tr>';
                    contactInfo += '<th scope="row">' + student.id + '</th>';
                    contactInfo += '<td>' + student.name + '</td>';
                    contactInfo += '<td>' + student.age + '</td>';
                    contactInfo += '<td>' + student.mobile + '</td>';
                    contactInfo += '<td>' + student.address + '</td>';
                    

                    contactsDiv.append(contactInfo);
                });
                contactsDiv.append('</tbody>');
                
            },
            error: function () {
                alert('FAILURE!');
            }
        })
    });
	
	$("button#submit").click(function(e){
		e.preventDefault();
		console.log('clicked');
		let name = $("#name").val();
		let age = $("#age").val();
		let mobile = $("#mobile").val();
		let address = $("#address").val();
		myJSObject = {name:name, age:age, mobile:mobile, address:address}
		 $.ajax({
            type: 'POST',
            url: 'http://localhost:9999/students',
            data: JSON.stringify(myJSObject),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function(){
				remove();
				loading();
				$( "#result" ).empty().append("Successfully added");
}
 	})
		$( '#myForm' ).each(function(){
    this.reset();
});

	})
	
	$("button#delete").click(function(e){
		e.preventDefault();
		console.log('clicked');
		let id = $("#id").val();
		 $.ajax({
            type: 'DELETE',
            url: 'http://localhost:9999/students/' + id,
            success: function(){
				remove();
				loading();
				
				$( "#result2" ).empty().append("Successfully deleted");
},
			error: function () {
                $( "#result2" ).empty().append("ID : " + id + " is not in the list");
            }
 	})
		$( '#deleteForm' ).each(function(){
    this.reset();
});

	})
	
	$("button#edit").click(function(e){
		e.preventDefault();
		console.log('clicked');
		let id = $("#searchId").val();
		let name = $("#updateName").val();
		let age = $("#updateAge").val();
		let mobile = $("#updateMobile").val();
		let addr = $("#updateAddress").val();
		
		$.ajax({
            type: 'PUT',
            url: 'http://localhost:9999/students/' + id + "/" + name + "/" + age + "/" + mobile + "/" + addr,
            success: function(){
	
				remove();
				loading();
				$( "#result3" ).empty().append("Successfully edited");
},
			error: function () {
				
                $( "#result3" ).empty().append("ID : " + id + " is not in the list");
            }	
 	})
		$( '#editForm' ).each(function(){
    this.reset();
    
    $("#updateName").attr("value", "");
    $("#updateAge").attr("value", "");
    $("#updateMobile").attr("value", "");
    $("#updateAddress").attr("value", "");
});

	})
	
	$("button#search").click(function (e) {
		e.preventDefault();
		console.log("clicked")
		let id = $("#searchId").val();
		
        $.ajax({
            type: 'GET',
            url: 'http://localhost:9999/students/' + id,
            success: function (a) {
				        
                $("#updateName").attr("value", a[0].name);
                $("#updateAge").attr("value", a[0].age);
                $("#updateMobile").attr("value", a[0].mobile);
                $("#updateAddress").attr("value", a[0].address);
                
            },
            error: function () {
                alert('FAILURE!');
            }
        })
      
    });
})





