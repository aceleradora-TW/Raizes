var path = require('path');

module.exports = (() => {
    global.appRoot = path.resolve(__dirname);
    global.nodeEnv = process.env.NODE_ENV === 'production' ? 'production' : 'development';
    global.devMode = nodeEnv !== 'production';
})()
