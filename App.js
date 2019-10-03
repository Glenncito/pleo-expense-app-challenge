import React from "react";
import store from "./src/store/store";
import Expenses from "./src/pages/Expenses";
import { Provider } from "react-redux";

const App = () => (
  <Provider store={store}>
    <Expenses />
  </Provider>
);

export default App;
