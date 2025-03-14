import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Router>
        <div className="container mx-auto p-4">
          <h1 className="text-3xl font-bold mb-4">Blog App</h1>
          <Routes>
            <Route path="/" element={<Posts />} />
            <Route path="/posts/:id" element={<PostDetails />} />
            <Route path="/new" element={<NewPost />} />
          </Routes>
        </div>
      </Router>
    </>
  )
}

export default App
