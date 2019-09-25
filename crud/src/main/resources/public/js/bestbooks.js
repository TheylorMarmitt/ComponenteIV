
$('#modal-excluir').on('show.bs.modal', function(e) {
	var codigo = $(e.relatedTarget).data('codigo');
	$(e.currentTarget).find("#excluir").val(codigo);
})
