import React from 'react'
import ReactDOM from 'react-dom/client'
import "reset-css"
import "./assets/gloabl.scss"
import { App } from './App.tsx'
import { BrowserRouter } from "react-router-dom"

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </React.StrictMode>,
)