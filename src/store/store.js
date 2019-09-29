import { configureStore, getDefaultMiddleware } from "redux-starter-kit";
import logger from "redux-logger";
import thunk from "redux-thunk";
import reducer from "./modules";

const middleware = [...getDefaultMiddleware(), logger, thunk];

const store = configureStore({
  reducer,
  middleware,
  devTools: process.env.NODE_ENV !== "production"
});

export default store;
