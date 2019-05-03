
const path = require('path');

module.exports = (() => ({
  mode: nodeEnv,
  devtool: devMode? 'source-map': '',
  entry: {
    bundle: path.join(appRoot,'/src/main/resources/assets/js/main.js')
  }
}))()