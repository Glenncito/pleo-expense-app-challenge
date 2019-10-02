import React from "react";
import store from "./src/store/store";
import Expenses from "./src/pages/Expenses";
import { Provider } from "react-redux";
import * as Localization from "expo-localization";
import { en, es } from "lib/constants";
import i18n from "i18n-js";

i18n.fallbacks = true;
i18n.translations = { en, es };
i18n.locale = "es";

const App = () => (
  <Provider store={store}>
    <Expenses />
  </Provider>
);

export default App;
