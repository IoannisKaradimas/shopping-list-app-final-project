import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ProductList extends Component {

    constructor(props) {
        super(props);
        this.state = {products: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/products')
            .then(response => response.json())
            .then(data => this.setState({products: data}));
    }

    async remove(id) {
          await fetch(`/products/${id}`, {
              method: 'DELETE',
              headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
              }
          }).then(() => {
              let updatedProducts = [...this.state.products].filter(i => i.id !== id);
              this.setState({products: updatedProducts});
              window.location.reload();
          });
      }

      render() {
          const {products, isLoading} = this.state;

          if (isLoading) {
              return <p>Loading...</p>;
          }

          const productList = products.map(product => {
              return <tr key={product.productId}>
                  <td style={{whiteSpace: 'nowrap'}}>{product.productDescription}</td>
                  <td>{product.quantity}</td>
                  <td>
                      <ButtonGroup>
                          <Button size="sm" color="primary" tag={Link} to={"/products/" + product.productId}>Edit</Button>
                          <Button size="sm" color="danger" onClick={() => this.remove(product.productId)}>Delete</Button>
                      </ButtonGroup>
                  </td>
              </tr>
          });

          return (
              <div>
                  <AppNavbar/>
                  <Container fluid>
                      <div className="float-right">
                          <Button color="success" style={{float: "right"}} tag={Link} to="/products/new">Add Product</Button>
                      </div>
                      <h3>Products</h3>
                      <Table className="mt-4">
                          <thead>
                          <tr>
                              <th width="30%">Description</th>
                              <th width="30%">Quantity</th>
                              <th width="40%">Actions</th>
                          </tr>
                          </thead>
                          <tbody>
                          {productList}
                          </tbody>
                      </Table>
                  </Container>
              </div>
          );
      }
}
export default ProductList;