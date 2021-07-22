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
				swal("No se elimino el usuario");
			}
		});
}

function eliminarCurso(id) {
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
					url:"/eliminarCurso/"+id,
					success: function(res) {
						console.log(res);
					}
				});
				swal("El curso ha sido eliminado correctamente", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/cursos";
					}
				});
			} else {
				swal("No se elimino el curso");
			}
		});
}

function eliminarAsignatura(id) {
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
					url:"/eliminarAsignatura/"+id,
					success: function(res) {
						console.log(res);
					}
				});
				swal("La asignatura ha sido eliminada correctamente", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/asignaturas";
					}
				});
			} else {
				swal("No se elimino la asignatura");
			}
		});
}