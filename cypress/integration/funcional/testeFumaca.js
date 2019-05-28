describe('Testa ambiente de homologação', function() {
    it('Carrega página do raízes', function() {
        cy.visit('https://raizes-homologacao.herokuapp.com/')

    })
})

describe('Testa titulo', function() {
    it('Testa titulo da página', function() {
        cy.visit('https://raizes-homologacao.herokuapp.com/')
        cy.title().should('eq', 'Aceleradora Ágil - Esqueleto Ambulante')
    })
})
