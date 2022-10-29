import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class ProductEdit extends Component {

    emptyItem = {
        description: '',
        quantity: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

  async componentDidMount() {
      if (this.props.match.params.id !== 'new') {
          const product = await (await fetch(`/products/${this.props.match.params.id}`)).json();
          this.setState({item: product});
      }
  }

  handleChange(event) {
      const target = event.target;
      const value = target.value;
      const name = target.name;
      let item = {...this.state.item};
      item[name] = value;
      this.setState({item});
  }

  async handleSubmit(event) {
      event.preventDefault();
      const {item} = this.state;

      await fetch('/products' + (item.id ? '/' + item.id : ''), {
          method: (item.id) ? 'PUT' : 'POST',
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(item),
      });
      this.props.history.push('/products');
  }

  render() {
      const {item} = this.state;
      const title = <h2>{item.id ? 'Edit Products' : 'Add Product'}</h2>;

      return <div>
          <AppNavbar/>
          <Container>
              {title}
              <Form onSubmit={this.handleSubmit}>
                  <FormGroup>
                      <Label for="productDescription">Description</Label>
                      <Input type="text" name="productDescription" id="productDescription" value={item.productDescription || ''}
                             onChange={this.handleChange} autoComplete="productDescription"/>
                  </FormGroup>
                  <FormGroup>
                      <Label for="quantity">Quantity</Label>
                      <Input type="text" name="quantity" id="quantity" value={item.quantity || ''}
                             onChange={this.handleChange} autoComplete="quantity"/>
                  </FormGroup>
                  <FormGroup>
                      <Button color="primary" type="submit">Save</Button>{' '}
                      <Button color="secondary" tag={Link} to="/products">Cancel</Button>
                  </FormGroup>
              </Form>
          </Container>
      </div>
  }
}
export default withRouter(ProductEdit);