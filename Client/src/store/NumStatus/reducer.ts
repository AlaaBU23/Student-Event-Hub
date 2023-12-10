//manage data
import handleNum from "./index";

let reducer = (state = { ...handleNum.state }, action: { type: string, val: number }) => {
  let newState = JSON.parse(JSON.stringify(state))
  // switch (action.type) {
  //   case "add1":
  //     handleNum.actions.add1(newState, action)
  //     break;
  //   case "add2":
  //     handleNum.actions.add2(newState, action)
  //     break;
  //   default:
  //     break
  // }
  for (let key in handleNum.actionNames) {
    if (action.type === handleNum.actionNames[key]) {
      handleNum.actions[handleNum.actionNames[key]](newState, action)
      break
    }
  }
  return newState
}
export default reducer
