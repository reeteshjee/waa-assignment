
import './App.css'
import Header from './components/Header';
import Posts from './components/Posts';
import Login from './components/Login';
import NewPost from './components/NewPost';
import { Route, Routes } from 'react-router-dom';

function App() {

  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<Posts />} />
        <Route path="/new-post" element={<NewPost />} />
        <Route path="/login" element={<Login />} />
      </Routes>


    </>
  )
}

export default App
