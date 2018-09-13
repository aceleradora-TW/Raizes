describe('A pagina Home', () => {

  it('carrega com sucesso', () => {
    cy.visit('/')
  })

  it('tem um titulo', () => {
    cy.get('h1').should('contain', 'Esqueleto Ambulante')
  })

  it('tem links para as paginas "inicio" e "participantes"', () => {
    cy.get('a > li').eq(0).should('contain', 'Início')
    cy.get('a > li').eq(1).should('contain', 'Participantes')
  })

})