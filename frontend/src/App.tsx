import { Routes, Route, NavLink, Navigate } from 'react-router-dom'
import Login from './pages/Login'
import Register from './pages/Register'
import Projects from './pages/Projects'
import ProjectDetails from './pages/ProjectDetails'
import Milestones from './pages/Milestones'
import Documents from './pages/Documents'
import Admin from './pages/Admin'
import { AuthProvider, useAuth } from './auth/AuthContext'

function PrivateRoute({ children }: { children: JSX.Element }){
  const { token } = useAuth()
  return token ? children : <Navigate to="/login" replace />
}

export default function App(){
  return (
    <AuthProvider>
      <nav className="navbar navbar-expand navbar-light bg-light px-3">
        <NavLink className="navbar-brand" to="/projects">Research Tracker</NavLink>
        <div className="navbar-nav">
          <NavLink className="nav-link" to="/projects">Projects</NavLink>
          <NavLink className="nav-link" to="/milestones">Milestones</NavLink>
          <NavLink className="nav-link" to="/documents">Documents</NavLink>
          <NavLink className="nav-link" to="/admin">Admin</NavLink>
        </div>
      </nav>
      <div className="container py-3">
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/projects" element={<PrivateRoute><Projects /></PrivateRoute>} />
          <Route path="/projects/:id" element={<PrivateRoute><ProjectDetails /></PrivateRoute>} />
          <Route path="/milestones" element={<PrivateRoute><Milestones /></PrivateRoute>} />
          <Route path="/documents" element={<PrivateRoute><Documents /></PrivateRoute>} />
          <Route path="/admin" element={<PrivateRoute><Admin /></PrivateRoute>} />
          <Route path="*" element={<Navigate to="/projects" />} />
        </Routes>
      </div>
    </AuthProvider>
  )
}
