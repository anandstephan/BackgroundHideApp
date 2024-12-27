import {NativeModules, Button, View} from 'react-native';
import React from 'react';

const App = () => {
  const {BackButtonModule} = NativeModules;
  return (
    <View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
      <Button
        title="Enable Custom Back Press"
        onPress={() => BackButtonModule.enableCustomBackPress()}
      />
      <Button
        title="Disable Custom Back Press"
        onPress={() => BackButtonModule.disableCustomBackPress()}
        style={{marginTop: 20}}
      />
    </View>
  );
};

export default App;
