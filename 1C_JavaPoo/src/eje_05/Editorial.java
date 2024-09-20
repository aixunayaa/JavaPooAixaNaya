package eje_05;

public class Editorial {
	//Las editoriales tienen nombre y país, y los autores tienen nombre,
		//nacionalidad y fecha de nacimiento.
		private String nombre;	
		private String pais;

		
		public Editorial(String nombre, String pais) {
			this.setNombre(nombre);
			this.setPais(pais);
		}
		
		public String getNombre() {
			return nombre;
		}

		public String getPais() {
			return pais;
		}

		private void setNombre(String nombre) {
			this.nombre = nombre;
		}

		private void setPais(String pais) {
			this.pais = pais;
		}

		
		
		
		
		
	}
