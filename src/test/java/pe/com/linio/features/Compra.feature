Feature: Flujo completo de compra

  Scenario Outline: Compra de producto
  Este escenario realizará la compra de un producto definido en el example.
  Para efectos de práctica, la compra no se concretará debido a que se encuentra en un sitio productivo.
    Given Digito la palabra "<searchWord>"
    When  Hago clic en boton de busqueda
    And Filtro por la marca "<marca>"
    And Filtro por catalogo "<catalogo>"
    And Ordeno el listado por "<ordenamiento>"
    Then Imprimo el número de resultados
    And Ordeno e imprimo los productos por nombre ascendente
    And Ordeno e imprimo los productos por precio descendente
    And Agrego los primeros <numProductos> productos
    Examples:
      | searchWord | marca | catalogo  | ordenamiento | numProductos |
      | laptops    | Apple | Notebooks | Menor precio | 3            |