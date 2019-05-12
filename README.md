# GestaoGastos
Desafio: API REST para gestão de gastos

# Bancos Necessários para aplicação funcionar
  solr
  redis
# Configurações
 Quando subir o banco Solr, criar a entidade gestaoGastos
 O banco está configurado para porta 8983, mas se precisar alterar porta do banco, vai precisar alterar o arquivo "aplication.properties"
 
# Como acessar a API GestãoGastos
  Ela está protegida, e só pode ser acessada quando passado um token. Terá um documento mostrando de como gerar este token.
  
# Cada método da controller representando uma funcionalidade do desafio

# Funcionalidade Obrigatória: Integração de gastos por cartão /Json para gerar esta funcionalidade

	@PostMapping("/gestaoGastos")
	public ResponseEntity<GestaoGastosDTO>criarGestaoGastos(@Valid @RequestBody GestaoGastosDTO gestaoGastosDTO){
		GestaoGastosDTO gestaoGastosSalva = gestaoGastosService.criar(gestaoGastosDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(gestaoGastosSalva);
	}
	
     {"codigoUsuario": 33,
        "descricao": "Mercado",
        "valor": 95.86,
        "data": "2019-05-08T08:16:22.825"
       
    }   
 # Funcionalidade Obrigatória: Listagem de gastos 
 
  @GetMapping("/gestaoGastos/{codigoUsuario}")
    public List<GestaoGastosDTO> buscarPorCodigoUsuario(@PathVariable Long codigoUsuario) {
    	return gestaoGastosService.buscarPorCodigoUsuario(codigoUsuario);
    }
    
  
#  Funcionalidade Eletiva: Filtro de gastos

@GetMapping("/gestaoGastos/{codigoUsuario}/{data}")
    public List<GestaoGastosDTO> buscarPorData(@PathVariable Long codigoUsuario,@PathVariable @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate data) {
    	return gestaoGastosService.buscarPorData(codigoUsuario,data);
    }
  
  # Funcionalidade Eletiva: Categorização de gastos / Json para gerar esta funcionalidade
  @PutMapping("/gestaoGastos")
	public ResponseEntity<GestaoGastosDTO>alterarGestaoGastos(@Valid @RequestBody GestaoGastosDTO gestaoGastosDTO){
		GestaoGastosDTO gestaoGastosSalva = gestaoGastosService.alterar(gestaoGastosDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(gestaoGastosSalva);
	}
  
  {"id": "7eb32870-fcb8-46fb-bd45-c22221847cb8",
    "codigoUsuario": 33,
    "descricao": "Mercado",
    "valor": 95.86,
    "data": "2019-05-08T08:16:22.825",
    "categoria": "teste"
  }
