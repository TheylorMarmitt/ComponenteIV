

$('#modal-excluir').on('show.bs.modal', function(e) {
	var codigo = $(e.relatedTarget).data('codigo');
	$(e.currentTarget).find("#excluir").val(codigo);
})

$('#excluir').on("click", function(e) {
	
	const codigo = e.target.value;
	
	$.ajax({
		method: "post",
		url:"excluir",
		data: pessoa = {'codigo': codigo }
	}).done(res => {
		console.log(res);
	})
});