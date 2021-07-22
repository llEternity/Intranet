function eliminar(id) {
	swal({
		title: "¿Estas seguro de eliminar?",
		text: "Una vez eliminado, los datos no se podran recuperar",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminarUsuario/"+id,
					success: function(res) {
						console.log(res);
					}
				});
				swal("El usuario ha sido eliminado correctamente", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/listarUsuarios";
					}
				});
			} else {
				swal("No se elimino el usuario!");
			}
		});
}