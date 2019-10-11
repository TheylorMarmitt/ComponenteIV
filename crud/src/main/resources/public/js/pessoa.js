



// $('#excluir').on("click", function(e) {
//
// 	const codigo = e.target.value;
//
// 	$.ajax({
// 		type:'post',
// 		url:'excluir',
// 		data: pessoa = {'codigo': codigo }
// 	}).done(res => {
//
// 	})
// });

$('#excluir').on("click", function(e) {

	$("body").bind("ajaxSend", function(elm, xhr){
		xhr.setRequestHeader('X-CSRF-Token', getCSRFTokenValue());
	});

	const codigo = e.target.value;


	$.ajax({
		// xhr.setRequestHeader(client),
		type: "post",
		url: 'excluir',
		// headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
		data: pessoa = {'codigo': codigo}

	}).done(res => {
		alert( "Data: " + res );

	})

});