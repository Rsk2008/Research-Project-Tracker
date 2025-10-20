import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import api from '../api'
import { useAuth } from '../auth/AuthContext'

export default function Login(){
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState<string | null>(null)
  const nav = useNavigate()
  const { login } = useAuth()

  const submit = async (e: any) => {
    e.preventDefault()
    setError(null)
    try {
      const { data } = await api.post('/api/auth/login', { username, password })
      login(data.token)
      nav('/projects')
    } catch (e:any) {
      setError(e?.response?.data || 'Login failed')
    }
  }

  return (
    <div className="row justify-content-center">
      <div className="col-12 col-md-6">
        <h3>Sign In</h3>
        <form onSubmit={submit}>
          <div className="mb-3">
            <label className="form-label">Username</label>
            <input required className="form-control" value={username} onChange={e=>setUsername(e.target.value)} />
          </div>
          <div className="mb-3">
            <label className="form-label">Password</label>
            <input required type="password" className="form-control" value={password} onChange={e=>setPassword(e.target.value)} />
          </div>
          {error && <div className="alert alert-danger">{error}</div>}
          <button className="btn btn-primary">Login</button>
        </form>
      </div>
    </div>
  )
}
