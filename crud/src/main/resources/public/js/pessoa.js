



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

	var client = rest.chain(csrf, {
		token: $("meta[name='_csrf']").attr("content"),
		name: $("meta[name='_csrf_header']").attr("content")
	});

	const codigo = e.target.value;

	$.ajax({
		// xhr.setRequestHeader(client),
		type: "post",
		url: 'excluir',
		// headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
		data: pessoa = {'codigo': codigo}

	}).done(res => {

	})

});