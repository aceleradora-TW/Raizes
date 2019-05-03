const path = require('path');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const webpack = require('webpack');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const SVGSpritemapPlugin = require('svg-spritemap-webpack-plugin');


module.exports = [
  new CleanWebpackPlugin(['dist'], {
    root: path.resolve(__dirname),
    verbrose: true,
  }),
  new webpack.DefinePlugin({
    'process.env': { NODE_ENV: nodeEnv},
  }),
  new MiniCssExtractPlugin({
    // filename: devMode ? 'css/app.css' : 'css/app.[hash].css', // para versionar
    filename: devMode ? 'css/app.css' : 'css/app.css',
    chunkFilename: devMode ? 'css/[id].css' : 'css/[id].[hash].css',
  }),

  new SVGSpritemapPlugin(path.join(appRoot, '/src/main/resources/assets/svgs/*.svg'), {
    output: {
      svg: {
        sizes: false
      },
      filename: 'svg/spritmap.svg',
    },
    sprite: {
      generate: {
        use: true,
        view: '-fragment',
        symbol: true
      },
    }
  })
]