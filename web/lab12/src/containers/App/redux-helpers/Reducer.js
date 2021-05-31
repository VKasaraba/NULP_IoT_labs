import { createCartItem, deleteCartItem } from "./Types";


const createItem = (state, action) => {
  let orders = state.orders.slice();
  orders.push(action.payload);
  return orders;
};

const deleteItem = (state, action) => {
  let orders = state.orders.slice();
  orders = orders.filter((element) => element.id !== action.payload.id);
  return orders;
};

const calculatePrice = (data) => {
  let sum = 0;
  for (let value of Object.values(data)) {
    sum += value.customerMonthlyPaymentInUAH;
  }
  return sum;
};

const reducer = (state = {}, action) => {
  let orders;
  switch (action.type) {
    case createCartItem:
        orders = createItem(state, action);
      return {
        totalPrice: calculatePrice(orders),
        orders
      };
    case deleteCartItem:
      orders = deleteItem(state, action);
      return {
        totalPrice: calculatePrice(orders),
        orders
      };
    default:
      return state;
  }
};

export default reducer;