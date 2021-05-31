import { createCartItem, deleteCartItem } from "./Types";

export const startAction = { type: "start", payload: "Starting" };

export const createItem = (item) => {
  return { type: createCartItem, payload: item };
};

export const deleteItem = (item) => {
  return { type: deleteCartItem, payload: item };
};