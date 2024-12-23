import React, {useState, useEffect} from 'react';
import {
  View,
  Text,
  Button,
  StyleSheet,
  TouchableWithoutFeedback,
  BackHandler,
} from 'react-native';
import {NativeModules} from 'react-native';

const App = () => {
  const [isPaused, setIsPaused] = useState(false);
  const {MyNativeModule} = NativeModules;
  console.log(MyNativeModule);
  const handlePause = () => {
    setIsPaused(true);
  };

  const handleResume = () => {
    setIsPaused(false);
  };
  useEffect(() => {
    if (isPaused) {
      const backHandler = BackHandler.addEventListener(
        'hardwareBackPress',
        () => true,
      );
      return () => backHandler.remove();
    }
  }, [isPaused]);
  return (
    <View style={styles.container}>
      <Text style={styles.text}>React Native Pause Screen Example</Text>
      <Button title="Pause Screen" onPress={handlePause} />

      {isPaused && (
        <TouchableWithoutFeedback>
          <View style={styles.overlay}>
            <Text style={styles.overlayText}>Screen is Paused</Text>
            <Button title="Resume" onPress={handleResume} />
          </View>
        </TouchableWithoutFeedback>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#f5f5f5',
  },
  text: {
    fontSize: 18,
    marginBottom: 20,
  },
  overlay: {
    position: 'absolute',
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
    backgroundColor: 'rgba(0, 0, 0, 0.7)',
    justifyContent: 'center',
    alignItems: 'center',
    zIndex: 10, // Ensures it's above all other UI elements
  },
  overlayText: {
    fontSize: 24,
    color: '#fff',
    marginBottom: 20,
  },
});

export default App;
