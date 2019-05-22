describe('Testa ambiente de produção', function() {
    it('Carrega página do raízes', function() {
        cy.visit('https://raizes-producao.herokuapp.com/')
    })
})

describe('Testa titulo', function() {
    it('Testa titulo da página', function() {
        cy.title().should('eq', 'Aceleradora Ágil - Esqueleto Ambulante')
    })
})
