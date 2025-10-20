import { useEffect, useState } from 'react'
import api from '../api'

export default function Admin(){
  const [users, setUsers] = useState<any[]>([])
  useEffect(()=>{ (async ()=>{
    const { data } = await api.get('/api/users')
    setUsers(data)
  })() },[])
  return (
    <div>
      <h3>Admin Panel</h3>
      <table className="table">
        <thead><tr><th>Username</th><th>Role</th></tr></thead>
        <tbody>
          {users.map(u => <tr key={u.id}><td>{u.username}</td><td>{u.role}</td></tr>)}
        </tbody>
      </table>
    </div>
  )
}
