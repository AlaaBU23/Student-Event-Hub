import { legacy_createStore, combineReducers } from "redux";
import handleNum from "./NumStatus/reducer";

//bulid data warehouse
const reducers = combineReducers({
  handleNum,
})

const store = legacy_createStore(reducers, window.__REDUX_DEVTOOLS_EXTENSION__ &&
  window.__REDUX_DEVTOOLS_EXTENSION__());
export default store
