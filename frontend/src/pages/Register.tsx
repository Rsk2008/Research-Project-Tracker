import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import api from '../api'
import { useAuth } from '../auth/AuthContext'

export default function Register(){
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [fullName, setFullName] = useState('')
  const [error, setError] = useState<string | null>(null)
  const nav = useNavigate()
  const { login } = useAuth()

  const submit = async (e: any) => {
    e.preventDefault()
    setError(null)
    try {
      const { data } = await api.post('/api/auth/signup', { username, password, fullName })
      login(data.token)
      nav('/projects')
    } catch (e:any) {
      setError(e?.response?.data || 'Signup failed')
    }
  }

  return (
    <div className="row justify-content-center">
      <div className="col-12 col-md-6">
        <h3>Sign Up</h3>
        <form onSubmit={submit}>
          <div className="mb-3">
            <label className="form-label">Full Name</label>
            <input required className="form-control" value={fullName} onChange={e=>setFullName(e.target.value)} />
          </div>
          <div className="mb-3">
            <label className="form-label">Username</label>
            <input required className="form-control" value={username} onChange={e=>setUsername(e.target.value)} />
          </div>
          <div className="mb-3">
            <label className="form-label">Password</label>
            <input required type="password" className="form-control" value={password} onChange={e=>setPassword(e.target.value)} />
          </div>
          {error && <div className="alert alert-danger">{error}</div>}
          <button className="btn btn-primary">Create account</button>
        </form>
      </div>
    </div>
  )
}
