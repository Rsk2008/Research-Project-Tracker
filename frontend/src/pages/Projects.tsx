import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import api from '../api'

type Project = { id: string, title: string, summary: string, status: string }
export default function Projects(){
  const [list, setList] = useState<Project[]>([])
  useEffect(()=>{ (async ()=>{
    const { data } = await api.get('/api/projects')
    setList(data)
  })() },[])
  return (
    <div>
      <h3>Projects</h3>
      <ul className="list-group">
        {list.map(p => <li key={p.id} className="list-group-item d-flex justify-content-between">
          <div>
            <div className="fw-bold">{p.title}</div>
            <div className="text-muted">{p.summary}</div>
          </div>
          <div>
            <span className="badge bg-secondary me-3">{p.status}</span>
            <Link className="btn btn-sm btn-outline-primary" to={`/projects/${p.id}`}>Open</Link>
          </div>
        </li>)}
      </ul>
    </div>
  )
}
