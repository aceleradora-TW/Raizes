
require('./index')
const plugins = require('./config/webpack/plugins')
const output = require('./config/webpack/output')
const base = require('./config/webpack/base')
const devServer = require('./config/webpack/devServer')
const optimization = require('./config/webpack/optimization')
const wbmodule = require('./config/webpack/module')

let config = {}
config = Object.assign(config, base);
config.output = output;
config.devServer = devServer;
config.optimization = optimization;
config.module = wbmodule;
config.plugins =  plugins;

module.exports = config;
