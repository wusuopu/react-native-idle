import { NativeModules } from 'react-native'

export default {
  disableIdleTimer() {
    NativeModules.RNIdle.disableIdleTimer()
  },

  enableIdleTimer() {
    NativeModules.RNIdle.enableIdleTimer()
  }
}
