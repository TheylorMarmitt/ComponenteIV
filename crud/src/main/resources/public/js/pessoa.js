
$('#excluir').on("click", function(e) {
	
	const codigo = e.target.value;
	
	$.ajax({
		method: "post",
		url:"excluir",
		data: pessoa = {'codigo': codigo }
	}).done(res => {
		
	})
});