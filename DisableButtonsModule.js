import {NativeModules} from 'react-native';

const {DisableButtonsModule} = NativeModules;
console.log(DisableButtonsModule, 'jjj');
// Function to disable hardware buttons
export const disableHardwareButtons = () => {
  DisableButtonsModule.disableButtons();
};

// Function to enable hardware buttons
export const enableHardwareButtons = () => {
  DisableButtonsModule.enableButtons();
};
