package br.unisanta.colecionador.model

interface ItemDao {
    fun adcionarItem(item: Item)
    fun obterItem(): List<Item>
    fun editarItem(nome: String, novoItem: Item)
    fun deletarItem(nome: String)

}