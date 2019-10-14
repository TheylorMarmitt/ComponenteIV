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

	var token = ($("#token").val());
	var header = ($("#header").val());

	const codigo = e.target.value;

	$.ajax({
		// xhr.setRequestHeader(client),
		type: "post",
		url: 'excluir',
		headers: {
			"X-CSRF-TOKEN": $('meta[name="_csrf"]').attr('content')
		},
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		data: pessoa = {'codigo': codigo}

	}).done(res => {
		location.reload();
	})
});