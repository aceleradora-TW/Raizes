const MiniCssExtractPlugin = require("mini-css-extract-plugin");

const path = require('path');

module.exports = {
  rules: [
    {
      test: /\.js$/,
      exclude: /node_modules/,
      loader: 'babel-loader',
      query: {
        presets: [['es2015', { modudules: false }]],
      },
    },

    {
      test: /\.(sa|sc|c)ss$/,
      use: [
        {
          loader: MiniCssExtractPlugin.loader,
          options: {
            hmr: devMode,
          },
        },
        'css-loader',
        {
          loader: 'postcss-loader',
          options: {
            plugins: () => [require('autoprefixer')]
          }
        },
        'sass-loader',
      ],
    },
    {
      test: /.(ttf|otf|eot|svg|woff(2)?)(\?[a-z0-9]+)?$/,
      use: [{
        loader: 'file-loader',
        options: {
          name: '[name].[ext]',
          outputPath: '/fonts',
          publicPath: path.join(appRoot, '/src/main/resources/static/assets/')
        }
      }]
    }
  ],
}