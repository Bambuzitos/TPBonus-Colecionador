package br.unisanta.colecionador.model

class ItemDaoImpl : ItemDao {
    companion object{
        private val itens = mutableListOf<Item>()
    }
    override fun adcionarItem(item: Item){
        itens.add(item)
    }
    override fun obterItem(): List<Item>{
        return itens
    }
    override fun editarItem(nome: String, novoItem: Item){

    }
    override fun deletarItem(nome: String){
        itens.removeAll{it.nome == nome}

    }
}