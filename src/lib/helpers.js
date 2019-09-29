import { uploadReceipt } from "../api/expenses";
import { NativeModules } from "react-native";

const CameraApplication = NativeModules.NativeCameraModule;

export const initReceiptMenu = async expenseId => {
  try {
    const message = await CameraApplication.initReceiptCapture(expenseId);
    console.log(message);
    uploadReceipt(expenseId, message);
  } catch (error) {
    console.error(error);
  }
};
